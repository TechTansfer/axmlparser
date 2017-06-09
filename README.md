# AXML parser
An updated version of AXMLParser, compatible with aapt2.

The library allows you to parse binary XML (such as the `AndroidManifest.xml`) from a generated APK file.
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