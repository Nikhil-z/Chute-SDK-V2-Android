Chute-SDK-V2-Android
====================

This is the official Android SDK for www.getchute.com API version 2


You can use it as a Maven dependency by adding the following to your list of dependencies in your pom.xml

    <dependency>
      <groupId>com.getchute.android.sdk.v2</groupId>
      <artifactId>chute-sdk-v2-android</artifactId>
      <version>2.0.2</version>
    </dependency>


Or use the jar with dependencies from target in your regular non-maven projects

# Changelog

## 2.1.1

	- Removed Account Store
	- Initialization should always go through Chute.init(context,authConstants); A recommended way of doing this is by extending the Application class and adding this piece of code inside onCreate();
	