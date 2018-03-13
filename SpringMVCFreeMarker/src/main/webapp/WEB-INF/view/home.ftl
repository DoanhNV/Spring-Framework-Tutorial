List String <br/>
<div>
	<#if user??>
		<#list users as user>
			<a href="${request.contextPath}">${user}</a><br/>
		</#list>
	</#if>
</div>
<br/>
List User
<br/>
	<#if listUser??>
		Size: ${listUser?size}
		<#list listUser as user>
			<h3>${user.name} - ${user.name?length} - ${user.email}</h3>
			Index: ${user?index} <br/>
			Counter: ${user?counter} <br/>
			Item Parity: ${user?item_parity} <br/>
			Item Cycle: ${user?item_cycle("Yellow","Red")} <br/>
			Start With: ${user.name?starts_with("D")?string("true","false")} <br>
			Capital First: ${user.name?cap_first} <br>
			Upper Case: ${user.name?upper_case} <br>
		</#list>
	</#if>
