#Url expander
It is a tool written in Java for expanding shortened URLs.

##Details
Url expander is development using Java 11 and the native HTTP Client, some details are available [here](https://openjdk.java.net/groups/net/httpclient/intro.html). 
Another feature of this tool is the use of multitasking (multithread) to optimize the time.

An important feature is the manage of timeouts and errors. When exist errors, the returned data will show it.  

##Using
The entry point of the library is a class named *ProcessExpander* and the method *expanderUrls*. A snippet of code is
showing in the next line.

```java
var results = ProcessExpander.expanderUrls(shortenUrls);
``` 

*expanderUrls* receive a List of shortened urls and returns a list of SEUrl objects. The SEUrl class has the following 
attributes:
* Long url, the expanded url. If errors a null value will be returned.
* Status code, HTTP status code. If errors the value attribute will be 0. 
* Mime type, the mime type of the resource.  If errors it will be null.
* Shortened url, the original short url. It always have a value.


 