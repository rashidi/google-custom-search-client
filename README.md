# Google Custom Search Client Library

Google offers an API for their [Custom Search][1]. However I find the [Java library they provided][2] is difficult to use and there is no sample of usage provided. After several attempts I gave up and decided to create my own.


## Building The Library

Before building the library, make sure that your machine has maven2 environment set up. Build the library with maven command:

	mvn clean install

There will two jar created. One includes dependencies while the other did not.


## Usage

You can find sample of usage in the [GoogleCustomSearchTest.java][4]


## Copyrights

The source code of this library is licensed under [WTFPL][3]. Feel free to do whatever you want with it.

[1]: http://www.google.com/cse/
[2]: https://developers.google.com/custom-search/v1/libraries
[3]: http://sam.zoy.org/wtfpl/
[4]: https://bitbucket.org/rashidi/google-custom-search-client/src/690263008b11d7f3cb073fd0f307cba01c87345f/src/test/java/my/zin/rashidi/google/GoogleCustomSearchTest.java?at=master
