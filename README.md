# gwt-test-json-speed-jsni
Testing speed of JSON encoder from RestyGWT vs GWT AutoBean.

http://www.gwtproject.org/doc/latest/DevGuideAutoBeans.html
https://resty-gwt.github.io/documentation/restygwt-user-guide.html
http://www.gwtproject.org/doc/latest/DevGuideCodingBasicsJSNI.html

Results (duration in ms, for 4000 elements) on my Mac mini, in superdev mode using Google Chrome.
autobean duration  = 217
resty duration  = 85
jsni duration  = 4

Same hardware, using Firefox (39.0):
autobean duration  = 451
resty duration  = 163
jsni duration  = 3

Very early conclusion: RestyGWT significantly faster than AutoBean, but completely blown away by
JSNI, which requires a LOT of boilerplate code.