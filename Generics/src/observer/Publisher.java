package observer;

import java.util.ArrayList;
import java.util.List;

public class Publisher {

	@SuppressWarnings("rawtypes")
	private static final ThreadLocal<List> subscribers = new ThreadLocal<List>();
	// 全ての購読者を一配列に入れる(べつのイベントの購読者も同じ配列にはいる)
	private static final ThreadLocal<Boolean> publishing =new ThreadLocal<Boolean>(){
		@Override
		protected Boolean initialValue() {
			return Boolean.FALSE;
		}
	};

	public static Publisher instance(){
		return new Publisher();
	}

	@SuppressWarnings("unchecked")
	public <T> void publish(final T event){
		if(publishing.get()) return;
		System.out.println("event : " + event.toString());
		try{
			publishing.set(Boolean.TRUE);
			List<Subscriber<T>> registeredSubscribers = subscribers.get();
			if(registeredSubscribers == null) return;
			Class<?> type = event.getClass();
			for(Subscriber<T> subscriber : registeredSubscribers){
				System.out.println("subscriber: " + subscriber.toString());
				Class<?> subscribedTo = subscriber.subscribedToEventType();
				if(subscribedTo == type || subscribedTo == Event.class){
					subscriber.handleEvent(event);
				}
			}
		} finally {
			publishing.set(Boolean.FALSE);
		}
	}

	public Publisher reset() {
		if(!publishing.get()) subscribers.set(null);
		return this;
	}

	@SuppressWarnings("unchecked")
	public <T> Publisher subscribe(Subscriber<T> subscriber) {
		if(publishing.get()) return this;
		List<Subscriber<T>> registeredSubscribers = subscribers.get();
		System.out.println("subscriber : " + subscriber.toString());
		if(registeredSubscribers == null) {
			System.out.println("subscribers create ");
			registeredSubscribers = new ArrayList<Subscriber<T>>();
			subscribers.set(registeredSubscribers);
		}
		registeredSubscribers.add(subscriber);
		return this;
	}
}
