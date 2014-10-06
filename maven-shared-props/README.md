Shared Properties Between Modules with Maven Alfresco SDK
====================

Sample structure for AMP modules building.

### Local environment

```
$ mvn clean package
```
* AMPs modules created on **dist/loc** folder
* Log file includes ```[REPO] Verifier value: LOC``` and ```[SHARE] Verifier value: LOC``` at boot sequence

### Test environment
```
$ mvn clean package -Ptest
```
* AMPs modules created on **dist/test** folder
* Log file includes ```[REPO] Verifier value: TEST``` and ```[SHARE] Verifier value: TEST``` at boot sequence

### PRE environment
```
$ mvn clean package -Ppre
```
* AMPs modules created on **dist/pre** folder
* Log file includes ```[REPO] Verifier value: PRE``` and ```[SHARE] Verifier value: PRE``` at boot sequence

### Production environment
```
$ mvn clean package -Ppro
```
* AMPs modules created on **dist/pro** folder
* Log file includes ```[REPO] Verifier value: PRO``` and ```[SHARE] Verifier value: PRO``` at boot sequence