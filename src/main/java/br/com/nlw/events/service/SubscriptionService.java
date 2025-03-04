package br.com.nlw.events.service;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nlw.events.dto.SubscriptionRankingByUser;
import br.com.nlw.events.dto.SubscriptionRankingItem;
import br.com.nlw.events.dto.SubscriptionResponse;
import br.com.nlw.events.exception.EventNotFoundException;
import br.com.nlw.events.exception.SubscriptionConflictException;
import br.com.nlw.events.exception.UserIndicadorNotFoundException;
import br.com.nlw.events.model.Event;
import br.com.nlw.events.model.Subscription;
import br.com.nlw.events.model.User;
import br.com.nlw.events.repository.EventRepo;
import br.com.nlw.events.repository.SubscriptionRepo;
import br.com.nlw.events.repository.UserRepo;

@Service
public class SubscriptionService {

	@Autowired
	private EventRepo evtRepo;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private SubscriptionRepo subRepo;

	public SubscriptionResponse createNewSubscription(String eventName, User user, Integer userId) {

		// Retrieve event by name.
		Event evt = evtRepo.findByPrettyName(eventName);
		if (evt == null) { // caso alternativo 2
			throw new EventNotFoundException("Evento " + eventName + " nao existe");
		}
		User userRec = userRepo.findByEmail(user.getEmail());
		if (userRec == null) { // caso alternativo 1
			userRec = userRepo.save(user);
		}

		User indicador = null;
		if (userId != null) {
			indicador = userRepo.findById(userId).orElse(null);
			if (indicador == null) {
				throw new UserIndicadorNotFoundException("Usuário indicador " + userId + " não existe");
			}
		}

		Subscription subs = new Subscription();
		subs.setEvent(evt);
		subs.setSubscriber(userRec);
		subs.setIndication(indicador);

		Subscription tmpSub = subRepo.findByEventAndSubscriber(evt, userRec);
		if (tmpSub != null) { // caso alternativo 3
			throw new SubscriptionConflictException(
					"Ja existe inscricao para o usuário " + userRec.getName() + " no evento " + evt.getTitle());
		}

		Subscription res = subRepo.save(subs);
		return new SubscriptionResponse(res.getSubscriptionNamber(),
				"http://codecraft.com/" + res.getEvent().getPrettyName() + "/" + res.getSubscriber().getId());
	}

	public List<SubscriptionRankingItem> getCompleteRanking(String prettyName){
		Event evt = evtRepo.findByPrettyName(prettyName);
		if (evt == null) {
			throw new EventNotFoundException("Ranking do evento " + prettyName + " nao existe");
		}
		return subRepo.generateRanking(evt.getEventId());
	}
	 
	
	public SubscriptionRankingByUser getRankingByUser(String prettyName, Integer UserId) {
		List <SubscriptionRankingItem> ranking = getCompleteRanking(prettyName);
		
		SubscriptionRankingItem item = ranking
				 .stream()
				 .filter(i->i.user_id().equals(UserId))
				 .findFirst()
				 .orElse(null);
		
		if (item == null) {
			throw new UserIndicadorNotFoundException("Não há inscrições com indicação do usuário " + UserId);
		}
		
		Integer posicao = IntStream
				 .range(0, ranking.size())
				 .filter(pos -> ranking.get(pos)
				 .user_id().equals(UserId))
				 .findFirst().getAsInt();
		
		return new SubscriptionRankingByUser(item, posicao+1);
	}
}
