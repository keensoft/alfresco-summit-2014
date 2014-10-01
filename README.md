alfresco-summit-2014
====================

keensoft participation at Alfresco Summit 2014 (London) includes two sessions:
* [10 Enhancements That Require Less Than 10 Lines of Code](https://summit.alfresco.com/london/sessions/10-enhancements-require-less-10-lines-code)
* [Shared Properties Between Modules with Maven Alfresco SDK](https://summit.alfresco.com/london/sessions/lightning-talks-3)

This repository includes sample code for both sessions.

## Prerequisites

If you are new to Alfresco and the Alfresco Maven SDK, you should start by reading [Jeff Potts' tutorial on the subject](http://ecmarchitect.com/alfresco-developer-series-tutorials/maven-sdk/tutorial/tutorial.html).

Compatibility
-------------

All modules should be compatible with Alfresco EE 4.2.2 and Alfresco CE 4.2.f or later.

However, they have been verified to work with Alfresco CE 4.2.f.

Every module has been tested on its own, so it's possible that they won't work all together on the same Alfresco installation.

Installation
------------

To install every module in Alfresco use the Alfresco Module Management tool. 
*Note* The modules ending with "repo" are repo modules and should only be installed in Alfresco Repo.
*Note* The modules ending with "share" are share modules and should only be installed in Alfresco Share. 

* Copy the amp files (on target directories) to your "amps" and "amps_share" directory in your Alfresco installation.
* Stop Alfresco
* Run bin/apply-amps.sh
* Start Alfresco

Repository structure
----

**10-enhancements**

The repository contains a folder for each session. Within that, there is a directory for each enhancement which can include different folders for repo and share modules.

* [10. Add a download button](https://github.com/keensoft/alfresco-summit-2014/tree/master/10-enhancements/10-download-quickshare)
* [9. Site creation ability](https://github.com/keensoft/alfresco-summit-2014/tree/master/10-enhancements/09-hide-create-site)
* [8. Changing document extension](https://github.com/keensoft/alfresco-summit-2014/tree/master/10-enhancements/08-rename-on-change-ext)
* [7. Setting create missing person](https://github.com/keensoft/alfresco-summit-2014/tree/master/10-enhancements/07-disable-create-missing-people)
* [6. Custom LDAP identification](https://github.com/keensoft/alfresco-summit-2014/tree/master/10-enhancements/06-custom-ldap-id)
* [5. PDF/A transformation](https://github.com/keensoft/alfresco-summit-2014/tree/master/10-enhancements/05-pdfa-transformer)
* [4. Importing original dates](https://github.com/keensoft/alfresco-summit-2014/tree/master/10-enhancements/04-import-original-dates)
* [3. Custom ELM node names](https://github.com/keensoft/alfresco-summit-2014/tree/master/10-enhancements/03-rename-on-imap-creation)
* [2. Site custom properties](https://github.com/keensoft/alfresco-summit-2014/tree/master/10-enhancements/02-custom-site-props)
* [1. Site templates with folders](http://ecmarchitect.com/archives/2014/04/04/3687) (external Jeff Potts)

**maven-shared-props**

The repository contains a folder for each module (repo and share).

License
----

MIT