# gwt-test-json-speed-jsni
Testing speed of JSON encoder
-----------------------------

## Selected frameworks

[AutoBeans] (http://www.gwtproject.org/doc/latest/DevGuideAutoBeans.html) 

[RestyGWT] (https://resty-gwt.github.io/documentation/restygwt-user-guide.html)

[JSNI overlay] (http://www.gwtproject.org/doc/latest/DevGuideCodingBasicsJSNI.html)

JSON tree structure
-------------------
Single parent node, few attributes, and single, large list of children with few attributes each.

First results
-------------

(duration in ms, for 4000 elements) on my Mac mini, in superdev mode.
 
Google Chrome:

* autobean duration  = 217
* resty duration  = 85
* jsni duration  = 4

Same hardware, using Firefox (39.0):

* autobean duration  = 451
* resty duration  = 163
* jsni duration  = 3

Very early conclusion
---------------------

RestyGWT significantly faster than AutoBean, but completely blown away by
JSNI, which requires a LOT of boilerplate code.

TODO
----

* testing in production mode
* other platforms, especially mobile tablet/phone
* more complex, deeper tree structures
* using maps
* check if BigDecimal rounding is acceptable