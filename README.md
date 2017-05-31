
# react-native-pagarme-mpos

## Getting started

`$ npm install react-native-pagarme-mpos --save`

### Mostly automatic installation

`$ react-native link react-native-pagarme-mpos`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-pagarme-mpos` and add `RNPagarmeMpos.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNPagarmeMpos.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.bmamone.RNPagarmeMposPackage;` to the imports at the top of the file
  - Add `new RNPagarmeMposPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-pagarme-mpos'
  	project(':react-native-pagarme-mpos').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-pagarme-mpos/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-pagarme-mpos')
  	```


## Usage
```javascript
import RNPagarmeMpos from 'react-native-pagarme-mpos';

// TODO: What to do with the module?
RNPagarmeMpos;
```
  