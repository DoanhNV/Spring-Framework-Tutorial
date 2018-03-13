<html><head><title>Hello Doanh</title></head><body></body></html>

<#macro hello name>
	Hello ${name}
</#macro>

<@hello name="doanh"/>


<#--------------------------------LIST--------------------------- -->

<#macro repeat list>
	<#list list as item>
		<b style="color:red;">${item}</b><br>
	</#list>
</#macro>

<br/><@repeat list=["DoanhNV","DoanhABC"]/>

<#--------------------------------NESTED--------------------------- -->

<#macro twiceagain>
	<br><#nested>
	<br><#nested>
	<br><#nested>
</#macro>

<@twiceagain>HelloDoanh</@twiceagain>

<#--------------------------------NESTED PARAM--------------------------- -->

<#macro list count>
	<#list 0..count as index>
		${index}. ABC <#nested index,index==4> <br/>
	</#list>
</#macro>
<br/>
<@list count=5 ;index,greatnumber>
	<#if greatnumber>Great!</#if>
</@list>

<#--------------------------------NESTED less than PARAM--------------------------- -->

<@list count=5 ;greatnumber>
	${greatnumber}
</@list>
