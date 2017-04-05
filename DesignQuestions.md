### RESTFul design questions:

1. How would you maintain backward compatibility with a RESTFul service?
  * Versioning could be added to your service by adding in the URL the version number. Something like `/v1/greatThings/` but with this approach you 
  * Another approach could be to have a proxy client fronting the older end point. This service is a simple proxy service which could maintain the ramp fraction in the RequestContext. The ramp fraction is calculated per request at the time of the request context creation and after that this context is cached for the duration of the request. By using a simple cache which is scoped per request.


### Denial of Service attache

1. How would you maintain 

[Hystrix and back pressure]: https://github.com/Netflix/Hystrix/issues/1089
