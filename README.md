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
    AntigateConfig config = new DefaultAntigateConfig();
2. Set your code:  
    config.setKey("your-code-here");
3. Create AntigateFacade:  
    AntigateFacade antigate = new AntigateFacade(config);
4. Send captcha file and get responce:  
    SendFileResponse sendFileResponse = antigate.sendFile(new URL("your-url-here"));
5. Get captha ID from response:  
    String captchaID = sendFileResponse.getCaptchaID();
6. Add get captcha status until you get result:  
    GetCaptchaStatusResponse getCaptchaStatusResponse = antigate.getCaptchaStatus(captchaID);