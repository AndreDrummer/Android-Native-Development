/** Copyright 2022 Amazon.com Inc. or its affiliates. All Rights Reserved. **/
define(["jquery","jquery-cookie","jqueryHelper","argumentNullError","queryParametersHelper","stringHelper","windowHelper","idlerHelper","misc","userRepository"],function($,a,b,c,d,e,f,g,h,i){var j;j={},j.cultureCodeAttributeName="data-culture-code",j.languageCookieName="AWSTraining_LMS_Language",j.lblSelectedLanguage=$("#lblSelectedLanguage"),j.divSelectedLanguage=$("#divSelectedLanguage"),j.divLanguageOptions=$("#divLanguageOptions");var k=27,l=" ";return j.initialize=function(a,b,d){if(!a)throw c.createInstance("lblSelectedLanguage");if(!b)throw c.createInstance("divSelectedLanguage");if(!d)throw c.createInstance("divLanguageOptions");d.find("a").click({lblSelectedLanguage:a,divLanguageOptions:d},function(a){return j.onLanguageSelected($(this).attr(j.cultureCodeAttributeName)),!1}),d.find("a").keydown({lblSelectedLanguage:a,divLanguageOptions:d},function(a){a.key==l?this.click():a.keyCode==k&&(a.preventDefault(),d.hide(),b.focus())}),b.on("keydown",function(a){"Enter"==a.key||a.key==l?(a.preventDefault(),d.toggle()):a.keyCode==k&&(a.preventDefault(),d.hide())})},j.showOptions=function(a){var b,c;!0===a&&(b=j.divSelectedLanguage.offset().left+j.divSelectedLanguage.width()-j.divLanguageOptions.width()+22,c=35,j.divLanguageOptions.css("top",c),j.divLanguageOptions.css("left",b+"px")),j.divSelectedLanguage.addClass("selected"),j.divLanguageOptions.show()},j.setDefaultLanguage=function(a,b){var d;if(!a)throw c.createInstance("lblSelectedLanguage");if(!b)throw c.createInstance("divLanguageOptions");d=j.getDefaultLanguage(b),a.html(d)},j.mobileOptionsDiv=b.select(".kiku-mobile-language-options"),j.mobileOptions=b.select(".kiku-mobile-language-options div.submenu-option"),j.initializeMobileMenu=function(){var a;h.validateObjectParameter(j.mobileOptions,"languageOptions.mobileOptions"),j.mobileOptions.click(function(){j.mobileLanguageOptionClicked($(this))}),a=j.getCurrentLanguageCode(),j.mobileOptionsDiv.find("a["+j.cultureCodeAttributeName+"='"+a+"']").addClass("active")},j.mobileLanguageOptionClicked=function(a){h.validateObjectParameter(a,"optionDiv"),j.onLanguageSelected(a.attr(j.cultureCodeAttributeName))},j.onLanguageSelected=function(a){e.isStringNullOrWhiteSpace(a)&&(a="en-us"),b.getCurrentCultureCode()!==a&&(j.setLanguageCookie(a),j.divLanguageOptions.hide(),g.showFull(),j.updatePreferredLanguageCode())},j.setLanguageCookie=function(a){if(e.isStringNullOrWhiteSpace(a))throw c.createInstance("languageCode");$.cookie(this.languageCookieName,a,{path:"/",expires:1e4})},j.getDefaultLanguage=function(a){var b;return h.validateObjectParameter(a,"divLanguageOptions"),b=j.getCurrentLanguageCode(),a.find("a["+j.cultureCodeAttributeName+"='"+b+"']").html()},j.getCurrentLanguageCode=function(){var a,c,d;return d=!0,c=(b.getCurrentCultureCode()||"").toLowerCase().trim(),c||(a=$.cookie(j.languageCookieName),e.isStringNullOrWhiteSpace(a)||(d=!1,c=a.toLowerCase().trim())),e.isStringNullOrWhiteSpace(c)&&(c="en-us"),!0===d&&j.setLanguageCookie(c),c},j.updatePreferredLanguageCode=function(){i.getCurrent(j.getCurrentUserCompleted,j)},j.getCurrentUserCompleted=function(a,b,c){var d;return!a||b?void f.reloadPage():(d=$.cookie(j.languageCookieName))?(a.PreferredLanguageCode=d,void i.updateProfile(a,j.getUpdateUserProfileCompleted,j)):void f.reloadPage()},j.getUpdateUserProfileCompleted=function(a,b,c){f.reloadPage()},j});