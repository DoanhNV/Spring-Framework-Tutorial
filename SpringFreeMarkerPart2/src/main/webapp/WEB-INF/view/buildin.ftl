<-------------------------------------- DATE TIME -----------------------------------------------><br/>
<#setting date_format="dd-MM-yyyy hh:mm">
<#setting locale="en_US">

Date: ${currentDate?date} <br/>
Time: ${currentDate?time} <br/>
Date Time: ${currentDate?datetime} <br/>
Custom Format Date: ${currentDate?string["yyyy/MM/dd"]} <br/>
Custom Format DateTime: ${currentDate?string["yyyy/MM/dd hh:mm:ss"]} <br/>

<#assign someDate = "10/25/1995"?date("MM/dd/yyyy")> ${someDate} <br/>

<-------------------------------------- NUMBER -----------------------------------------------><br/>
<#list 1..10 as n>
	${n?lower_abc}
</#list>

Not a number: 
<#assign count=3.144 />
<#assign name="Doanh" />
<br>Is not a number: ${count?is_nan?string("true","false")}
<br> Round: ${count?round}
<br> Floor: ${count?floor}
<br> Ceiling: ${count?ceiling}