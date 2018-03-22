List of users:
<#assign users = [{"name":"Joe","hidden":false},
                  {"name":"James Bond", "hidden":true},
                  {"name":"Julia",      "hidden":false}]>
<#assign names=["ABC","123"]/>
<ul>
<#list users as user>
  <#if !user.hidden>
 	 <li>${user.name}</li>
  </#if>
</#list>
</ul>


<br/>
List Name:<br/>
<#list names as name>
	${name?index}.${name}<br/>
</#list>