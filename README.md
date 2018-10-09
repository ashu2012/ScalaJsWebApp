scalajs-react-android app
======================

Basic skeleton app for scalajs-react and scalacss

scalajs understanding
```
https://www.toptal.com/scala/using-scala-js-with-npm-and-browserify
https://medium.com/@michaelmangial1/getting-started-with-scala-js-scalavue-and-scalareact-for-the-javascript-developer-ac578ddcb5a8
http://scalapro.net/designing-facades-in-scala-js/
https://medium.com/@takezoe/integrate-scala-js-with-existing-javascript-eco-system-1b841cfc6431
```

### Launch this project:
```
1. clone the project
a run below command from root of project folder
b sbt clean compile fastOptJS::webpack
c above command creats a target /AndroidApp/target/scala-2.12/scalajs-bundler/main
 copy above buindel and launcher.js files in to root project folder under js folder
d sudo npm install -g webpack@
```

```

2. In the project directory run:
a  in root project loaction edit index.html file with notepad and edit js script tags to
b`sbt ~fastOptJS`
```

```
3. On your browser go to:
a. http://localhost:12345/index.html
b. Note http://127.0.0.1:12345/ will not work only above one will work
```

4.Below are for material UI and google components
scalajs project we can add nodejs dependencies and build them


```

if facing issue with npm 6.0.0, update it using below:-
sudo npm i npm@next -g



ashutosh@atp:~/Development/AndroidApp$ sbt webpack::version
[info] Loading global plugins from /home/ashutosh/.sbt/0.13/plugins
[info] Loading project definition from /home/ashutosh/Development/AndroidApp/project
[info] Set current project to scalajs-react-template (in build file:/home/ashutosh/Development/AndroidApp/)
[info] 2.6.1
ashutosh@atp:~/Development/AndroidApp$ npm version
{ npm: '6.0.0',
  ares: '1.10.1-DEV',
  http_parser: '2.8.0',
  icu: '58.2',
  modules: '48',
  node: '6.14.1',
  openssl: '1.0.2o',
  uv: '1.16.1',
  v8: '5.1.281.111',
  zlib: '1.2.11' }

┌────────────────────────────────────────────────────────────┐
│                  npm update check failed                   │
│            Try running with sudo or get access             │
│            to the local update config store via            │
│ sudo chown -R $USER:$(id -gn $USER) /home/ashutosh/.config │
└────────────────────────────────────────────────────────────┘





nodejs minimum =6
Realted package installation
curl -sL https://deb.nodesource.com/setup_6.x | sudo -E bash -

echo "Installing NodeJS 6.x"
sudo apt-get install nodejs

echo "Install webpack globally"
sudo npm install webpack -g

echo "Install nightwatch globally"
sudo npm install webpack -g

sudo npm install -g brunch

echo "Install Selenium standalone globally"
sudo npm install selenium-standalone@latest -g
sudo selenium-standalone install

echo "Installing Yarn"
curl -sS https://dl.yarnpkg.com/debian/pubkey.gpg | sudo apt-key add -
echo "deb https://dl.yarnpkg.com/debian/ stable main" | sudo tee /etc/apt/sources.list.d/yarn.list
sudo apt-get update && sudo apt-get install yarn -y --allow-unauthenticated

echo "Installing driver"
#sudo selenium-standalone install --drivers.chrome.version=2.29 --drivers.chrome.baseURL=https://chromedriver.storage.googleapis.com

#selenium-standalone start install -y nodejs
```

How to setup for react android app after generating bundle js

```
To get set up with the basic project structure for a native module we will use a third party tool react-native-create-library. You can go ahead further and dive deep into how that library works, for our needs we will just need:

$ npm install -g react-native-create-library
$ react-native-create-library MyLibrary

Where MyLibrary is the name you would like for the new module. After doing this you will navigate into MyLibrary folder and install the npm package to be locally available for your computer by doing:

$ npm install

After this is done you can go to your main react app folder (which you created by doing react-native init MyApp)

    add your newly created module as a dependency in your package.json
    run npm install to bring it along from your local npm repository.

```

```
Assuming that you have Node installed, you can use npm to install the create-react-native-app command line utility:

npm install -g create-react-native-app

Then run the following commands to create a new React Native project called "AwesomeProject":

create-react-native-app AwesomeProject

cd AwesomeProject
npm start

This will start a development server for you.
```


```
Running your app on a simulator or virtual device

Create React Native App makes it really easy to run your React Native app on a physical device without setting up a development environment. If you want to run your app on the iOS Simulator or an Android Virtual Device, please refer to the instructions for building projects with native code to learn how to install Xcode and set up your Android development environment.

Once you've set these up, you can launch your app on an Android Virtual Device by running npm run android, or on the iOS Simulator by running npm run ios (macOS only).
```


```
Success! Created AwesomeProject at /home/ashutosh/Development/AwesomeProject
Inside that directory, you can run several commands:

  npm start
    Starts the development server so you can open your app in the Expo
    app on your phone.

  npm run ios
    (Mac only, requires Xcode)
    Starts the development server and loads your app in an iOS simulator.

  npm run android
    (Requires Android build tools)
    Starts the development server and loads your app on a connected Android
    device or emulator.


  npm test
    Starts the test runner.

  npm run eject
    Removes this tool and copies build dependencies, configuration files
    and scripts into the app directory. If you do this, you can’t go back!


We suggest that you begin by typing:

  cd AwesomeProject
  npm start

Happy hacking!


```


FirebAse Setup
```
login google:-
Web client ID
1021787054473-el1f4e09s9eas3u3s9geap4no1oojdru.apps.googleusercontent.com
Web client secret
CfaosKOl08GhQJWq3m51Z3Jb


firebase authentication UI
https://github.com/firebase/firebaseui-web
http://softauthor.com/learn-to-build-firebase-crud-app-with-javascript-part01-reading-data/
https://github.com/FirebaseExtended/reactfire
```


React tools
```

C:\Users\h217119\IdeaProjects\ScalaJsWebApp>npm install -g react-devtools
C:\Users\h217119\AppData\Roaming\npm\react-devtools -> C:\Users\h217119\AppData\Roaming\npm\node_modules\react-devtools\bin.js

> electron@1.8.8 postinstall C:\Users\h217119\AppData\Roaming\npm\node_modules\react-devtools\node_modules\electron
> node install.js

Downloading SHASUMS256.txt
[============================================>] 100.0% of 5.74 kB (5.74 kB/s)
+ react-devtools@3.3.2
added 235 packages from 144 contributors in 853.228s

C:\Users\h217119\IdeaProjects\ScalaJsWebApp>npm install -g react-devtools --save
C:\Users\h217119\AppData\Roaming\npm\react-devtools -> C:\Users\h217119\AppData\Roaming\npm\node_modules\react-devtools\bin.js
+ react-devtools@3.3.2
updated 1 package in 22.387s

```

react camera
```
npm install react-camera --save
```

npm update dependencies
```


npm i -g npm-check-updates
ncu -u
npm install

```


###
Scala js bundler to add npm dependencies
```
https://github.com/scalacenter/scalajs-bundler/blob/master/manual/src/ornate/cookbook.md
http://scala-js.github.io/scala-js-dom/
https://www.scala-lang.org/blog/2016/10/19/scalajs-bundler.html
https://medium.com/@michaelmangial1/getting-started-with-scala-js-scalavue-and-scalareact-for-the-javascript-developer-ac578ddcb5a8
https://medium.com/@ruthmpardee/passing-data-between-react-components-103ad82ebd17
https://codepen.io/AleGonzalez/pen/YWxXaj
```

scalajs-react vs sri
```
https://stackoverflow.com/questions/33125601/scalajs-react-vs-xored-scalajs-react-vs-sri
```



Mobile testing and producct listing component example and free news api
```
https://app.crossbrowsertesting.com/trial_started
http://reactdemo.emmanuelyusufu.com/
http://stellarcode.co/build-a-product-hunt-inspired-app-with-react-2/
https://medium.freecodecamp.org/how-to-build-a-basic-version-of-product-hunt-using-react-f87d016fedae
https://reactjs.org/docs/thinking-in-react.html

https://newsapi.org/register/success
api:-Your API key is: aea30ab672ab45f28de1236014d6b1aa
https://newsapi.org/v2/top-headlines?country=in&category=business&apiKey=aea30ab672ab45f28de1236014d6b1aa
curl https://newsapi.org/v2/everything -G \
    -d q=Apple \
    -d from=2018-10-09 \
    -d sortBy=popularity \
    -d apiKey=aea30ab672ab45f28de1236014d6b1aa


https://newsapi.org/v2/everything?q=stocks&from=2018-10-01&sortBy=popularity&apiKey=aea30ab672ab45f28de1236014d6b1aa
```