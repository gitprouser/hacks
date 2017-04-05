### RESTFul design questions:

1. How would you maintain backward compatibility with a RESTFul service?
  * Versioning could be added to your service by adding in the URL the version number. Something like `/v1/greatThings/` but with this approach you 
  * Another approach could be to have a proxy client fronting the older end point. This service is a simple proxy service which could maintain the ramp fraction in the RequestContext. The ramp fraction is calculated per request at the time of the request context creation and after that this context is cached for the duration of the request. By using a simple cache which is scoped per request.


### Denial of Service attache

1. How would you maintain resilency in a distributed service?
[Hystrix and back pressure](https://github.com/Netflix/Hystrix/issues/1089)

2. What is back pressure and when would you use it? 
[Reactor](https://github.com/reactor/reactor-core) check this framework it has something about back pressure

3. When do you do retries in a distributed service and when do you simply give up? 
  * You would do multiple retries when you have issues in terms of *Network latency* or *Timeout* issues. This is more on the layer 3 or layer 4 issue. But once you find a down stream service throws a *500* HTTP response. It's invariably best to start doing an exponential back off and not do retries. 
  * Also another best practice in such situations is to simply FAIL-FAST. When you are trying to get a resource which doesn't exist or has issues when calling down stream service. You are much better off just failing fast and bubble up the exception to your caller as opposed to keep trying over and over again.
