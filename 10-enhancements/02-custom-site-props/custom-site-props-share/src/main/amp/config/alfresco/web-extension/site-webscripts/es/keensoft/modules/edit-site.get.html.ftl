<#assign el=args.htmlid?html>
<@markup id="custom-fields" action="after" target="fields"> 
<#list profile.customProperties?keys as prop>
   <#assign customValue=profile.customProperties[prop].value>
   <#assign customName=profile.customProperties[prop].name?substring(profile.customProperties[prop].name?index_of("}") + 1)>
    <div class="yui-gd">
       <div class="yui-u first"><label for="${el}-idEntity">${customName}:</label></div>
       <div class="yui-u"><input id="${el}-idEntity" type="text" name="idEntity" tabindex="0" value="${customValue}" /></div>
    </div>
</#list>		
</@markup>