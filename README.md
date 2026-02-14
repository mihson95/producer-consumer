# producer-consumer

Producer and Consumer communicating via Observer Pattern in Java.

## Current design and implementation gaps identified

- **No message payload in callbacks**: the original `consumeMessage()` API had no message data, which makes it hard to propagate meaningful events.
- **Duplicate registration was possible**: a consumer could be registered multiple times and receive duplicate notifications.
- **No registration result contract**: callers could not tell whether `register`/`deregister` actually changed producer state.
- **Potential iteration hazards**: mutating subscribers while iterating can lead to inconsistent dispatch behavior.
- **Limited error handling**: null registration inputs were not validated.

## Improvements implemented

- `Consumer.consumeMessage` now accepts a `String message` payload.
- `Producer` now returns `boolean` for `register` and `deregister` and `int` for dispatched message count.
- `ProducerImpl` now uses a `LinkedHashMap<Integer, Consumer>` keyed by consumer ID to prevent duplicates while preserving deterministic notification order.
- `ProducerImpl` is synchronized for registry mutation and uses a snapshot list when dispatching notifications.
- Added argument validation for null consumer registration.

## Run

```bash
javac $(find src -name '*.java')
java -cp src com.main.Application
```
