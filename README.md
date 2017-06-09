# AXML parser
An updated version of AXMLParser, compatible with aapt2.

The library allows you to parse binary XML (such as the `AndroidManifest.xml`) from a generated APK file.

The current implementation is based on the android4me project, on the work of Ryszard Wiśniewski and Dmitry Skiba: [https://code.google.com/archive/p/android4me/](https://code.google.com/archive/p/android4me/)

## Gradle dependency
```
dependencies {
    compile 'com.shazam:axmlparser:1.0'
}
```
## Example

```
AXMLParser parser = new AXMLParser(apkFileInputStream);
int eventType = parser.getType();
while (eventType != AXMLParser.END_DOCUMENT) {
    String parserName = parser.getName();
    boolean isManifest = "manifest".equals(parserName);
    [...]
    eventType = parser.next();
}
```
