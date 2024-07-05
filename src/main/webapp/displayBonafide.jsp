<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<title><%= request.getAttribute("name") %>Bonafide Certificate</title>
<link rel="stylesheet" href="bonafideStyle.css">
</head>
<body>
	<div class="border">
		<div class="photo">
			<div style=" align-items: center; padding:77px 40px;">Photo</div>
		</div>
		<div class="schlName">
			<p>Swami Vivekanand Bahuuddeshiya Sanstha</p>
			<h2>VIDYANIKETAN PUBLIC SCHOOL, Kudwa</h2>
			<p>TAH+DISTT.GONDIA</p>
			<h2>
				<span>BONAFIDE CERTIFICATE</span>
			</h2>
			<p>This is to Certify that</p>
		</div>
		<div class="middlesec">
			<p>
				Shri/Ku.
				<%=request.getAttribute("studentFullName")%>
				is a bonafide student of our school. He/She is learning in class
				<%=request.getAttribute("classOfAdmission")%>. Session: 202_ -
				202_. Admission no.:
				<%=request.getAttribute("registerNo")%>. Caste:
				<%=request.getAttribute("caste")%>. Date of birth:
				<%= request.getAttribute("dobFigures") %>. Mother's name:
				<%=request.getAttribute("motherName")%>. Place of birth:
				<%=request.getAttribute("placeOfBirth")%>.
			</p>
		</div>
		<div class="bottom">
			<div class="place">
				Place: Kudwa<br>Date: _____________________
			</div>
			<div class="sign">Head Master/Principal</div>
		</div>
	</div>
</body>
</html>
