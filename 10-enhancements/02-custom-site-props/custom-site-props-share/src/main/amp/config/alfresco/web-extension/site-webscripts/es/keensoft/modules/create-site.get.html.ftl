<@markup id="custom-properties" target="fields" action="after">
<#assign el=args.htmlid?html>
    <div class="yui-gd">
       <div class="yui-u first"><label for="${el}-idEntity">Entity:</label></div>
       <div class="yui-u"><input id="${el}-idEntity" type="text" name="idEntity" tabindex="0" /></div>
    </div>
</@markup>