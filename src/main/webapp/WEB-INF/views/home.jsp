<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=utf8"  %>

<html>
<head>
	<title>Home</title>
	<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
<h1>
	명함 요청 웹뷰
</h1>

<P>  The time on the server is ${serverTime}. </P>




<input type="text"  id="empId"/>
<input type="button"  value="명함 열기" OnClick="javascript:getBusinessCardById()"/>
<script type="text/javascript">
	var getBusinessCardById = function (){
		AndroidApp.callNative($("#empId")[0].value);
	}
</script>
</body>

</html>
