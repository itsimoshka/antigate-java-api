antigate-java-api
=================

Java library for antigate.com

Installation
------------

1. Download sources from https://github.com/itsimoshka/antigate-java-api.git
2. Go to sources directory
3. Run 'mvn clean install' (Maven should be installed previously)
4. Get antigate-java-api-XX.jar from target folder

Usage
-----

1. Create config object. You can use default implementation:  
    <pre>AntigateConfig config = new DefaultAntigateConfig();</pre>
2. Set your code:  
    <pre>config.setKey("your-code-here");</pre>
3. Create AntigateFacade:  
    <pre>AntigateFacade antigate = new AntigateFacade(config);</pre>
4. Send captcha file and get responce:  
    <pre>SendFileResponse sendFileResponse = antigate.sendFile(new URL("your-url-here"));</pre>
5. Get captha ID from response:  
    <pre>String captchaID = sendFileResponse.getCaptchaID();</pre>
6. Add get captcha status until you get result:  
    <pre>GetCaptchaStatusResponse getCaptchaStatusResponse = antigate.getCaptchaStatus(captchaID);</pre>