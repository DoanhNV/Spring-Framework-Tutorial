<#ftl>
<#-- at least freemarker 2.4-->
[#assign animals=["Pig","chicken","bird","buffullow"]]
[#list animals as animal]
	${animal}<br/>
[/#list]