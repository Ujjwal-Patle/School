<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title><%= request.getAttribute("name") %> School Leaving Certificate</title>
<link rel="stylesheet" href="leavingStyle.css">

</head>
<body>
	<div class="container">
		<div class="header">
			<h4>Swami Vivekanand Bahuudeshiya Sanstha, Kudwa, Gondia</h4>
			<h1>VIDYANIKETAN PUBLIC SCHOOL, KUDWA</h1>
			<h4>Tah. + Dist. GONDIA (M.S.)</h4>
			<h4>(See Rule 17 and 32 in Chapter || Section II)</h4>
		</div>

		<div class="info-line">
			<span>School Approval No: .......................</span> <span>Email:
				vnps.gondia@gmail.com</span>
		</div>
		<div style="margin-top: 2px;">Udise No. 27110407714</div>
		<div class="about">
			<h1>LEAVING CERTIFICATE</h1>
			<p>[No change in any entry in this certificate shall be made
				except by the authority issuing it & any infringement of this
				requirement is liable to involve the imposition of penalty such as
				that of restriction]</p>
			<h2>APPENDIX - 2</h2>
		</div>
		<div class="midSection">
			<div class="space">
				Register No. of the Pupil: <span class="underline"> <%
 String registerNo = (String) request.getAttribute("registerNo");
 if (registerNo == null) {
 	registerNo = "";
 }

 int totalLength = 8; // Set the total fixed position length
 int regNoLength = registerNo.length();

 for (int i = 0; i < totalLength; i++) {
 	if (i < regNoLength) {
 		out.print("<span class='underline-space'>" + registerNo.charAt(i) + "</span>");
 	} else {
 		out.print("<span class='underline-space'>&nbsp;</span>");
 	}
 }
 %>
				</span> <span>&nbsp UID No. (Aadhar Card No.):</span>
				<div class="aadhar-box">
					<%
					String adharCardNo = (String) request.getAttribute("adharCardNo");
					if (adharCardNo != null && adharCardNo.length() == 12) {
						for (int i = 0; i < adharCardNo.length(); i++) {
							out.print("<span class='aadhar-digit'>" + adharCardNo.charAt(i) + "</span>");
						}
					} else {
						out.print("No Aadhar Card Number found or invalid length");
					}
					%>
				</div>
			</div>
			<div class="space">
				<span>Sr. No.: ................</span> <span>&nbspStudent ID:</span>
				<div class="id-box">
					<%
					String stdID = (String) request.getAttribute("studentId");
					if (stdID == null) {
						stdID = "";
					}

					int totalBlocks = 24;
					int idLength = stdID.length();

					int emptyBlocks = totalBlocks - idLength;
					for (int i = 0; i < emptyBlocks; i++) {
						out.print("<span class='id-digit'>0</span>");
					}

					for (int i = 0; i < idLength; i++) {
						out.print("<span class='id-digit'>" + stdID.charAt(i) + "</span>");
					}
					%>
				</div>
			</div>

			<div class="new">
				<div class="underline-container">
					<span>Student Full Name:</span> <span class="underline">
						<%
						String fullName = (String) request.getAttribute("studentFullName");
						if (fullName == null) {
							fullName = "";
						}

						int fixedLength = 100; // Set the total fixed position length
						int fullNameLength = fullName.length();

						for (int i = 0; i < fixedLength; i++) {
							if (i < fullNameLength) {
								out.print("<span class='underline-space'>" + fullName.charAt(i) + "</span>");
							}
						}
						%>
					</span> <span>Mother's Name:</span> <span class="underline">
						<%
						String motherName = (String) request.getAttribute("motherName");
						if (motherName == null) {
							motherName = "";
						}

						int motherNameLength = motherName.length();

						for (int i = 0; i < 90; i++) {
							if (i < motherNameLength) {
								out.print("<span class='underline-space'>" + motherName.charAt(i) + "</span>");
							} else {
								out.print("<span class='underline-space'>&nbsp;</span>");
							}
						}
						%>
					</span>
				</div>
			</div>
			<div class="space">
				<span>Nationality: Indian</span> <span>Mother Tongue:
					Marathi/Hindi_________________</span> <span>Religion: <%=request.getAttribute("religion")%>__________
				</span>
			</div>
			<div class="space">
				<span>Caste: <span class="underline">
						<%
						String castName = (String) request.getAttribute("caste");
						if (castName == null) {
							castName = "";
						}

						int castNameLength = castName.length();

						for (int i = 0; i < 55; i++) {
							if (i < castNameLength) {
								out.print("<span class='underline-space'>" + castName.charAt(i) + "</span>");
							} else {
								out.print("<span class='underline-space'>&nbsp;</span>");
							}
						}
						%>
				</span>
				</span> <span>Caste Category: <span class="underline">
						<%
						String castCName = (String) request.getAttribute("casteCategory");
						if (castCName == null) {
							castCName = "";
						}

						int castCNameLength = castCName.length();

						for (int i = 0; i < 50; i++) {
							if (i < castCNameLength) {
								out.print("<span class='underline-space'>" + castCName.charAt(i) + "</span>");
							} else {
								out.print("<span class='underline-space'>&nbsp;</span>");
							}
						}
						%>
				</span>
				</span>
			</div>
			<div class="space">
				<span>Place of Birth (Village/City): <span class="underline">
						<%
						String placeBirth = (String) request.getAttribute("placeOfBirth");
						if (placeBirth == null) {
							placeBirth = "";
						}

						int placeBirthLength = placeBirth.length();

						for (int i = 0; i < 50; i++) {
							if (i < placeBirthLength) {
								out.print("<span class='underline-space'>" + placeBirth.charAt(i) + "</span>");
							} else {
								out.print("<span class='underline-space'>&nbsp;</span>");
							}
						}
						%>
				</span>
				</span> <span>Taluka: <span class="underline">
						<%
						String taluka = (String) request.getAttribute("taluka");
						if (taluka == null) {
							taluka = "";
						}

						int talukaLength = taluka.length();

						for (int i = 0; i < 40; i++) {
							if (i < talukaLength) {
								out.print("<span class='underline-space'>" + taluka.charAt(i) + "</span>");
							} else {
								out.print("<span class='underline-space'>&nbsp;</span>");
							}
						}
						%>
				</span>
				</span>
			</div>
			<div class="space">
				<span>District: <span class="underline">
						<%
						String district = (String) request.getAttribute("district");
						if (district == null) {
							district = "";
						}

						int districtLength = taluka.length();

						for (int i = 0; i < 40; i++) {
							if (i < districtLength) {
								out.print("<span class='underline-space'>" + district.charAt(i) + "</span>");
							} else {
								out.print("<span class='underline-space'>&nbsp;</span>");
							}
						}
						%>
				</span>
				</span> <span>State: <span class="underline">
						<%
						String state = (String) request.getAttribute("state");
						if (state == null) {
							state = "";
						}

						int stateLength = state.length();

						for (int i = 0; i < 50; i++) {
							if (i < stateLength) {
								out.print("<span class='underline-space'>" + state.charAt(i) + "</span>");
							} else {
								out.print("<span class='underline-space'>&nbsp;</span>");
							}
						}
						%>
				</span>
				</span> <span>Country: India</span>
			</div>
			<div class="space1">
				<span>Date of Birth According to the Christian era (both in
					words and figures): <span class="underline">
						&nbsp&nbsp&nbsp&nbsp&nbsp<%=request.getAttribute("dobFigures")%>
						&nbsp&nbsp&nbsp&nbsp&nbsp
				</span>
				</span> <span>(In words): <span class="underline">
						<%
						String dobWords = (String) request.getAttribute("dobWords");
						if (dobWords == null) {
							dobWords = "";
						}

						int dobWordsLength = dobWords.length();

						for (int i = 0; i < 110; i++) {
							if (i < dobWordsLength) {
								out.print("<span class='underline-space'>" + dobWords.charAt(i) + "</span>");
							} else {
								out.print("<span class='underline-space'>&nbsp;</span>");
							}
						}
						%>
				</span>
				</span>
			</div>
			<div class="space1">
				<span>Last School Attended Name: <span class="underline">
						<%
						String lastSchoolName = (String) request.getAttribute("lastSchoolName");
						if (lastSchoolName == null) {
							lastSchoolName = "";
						}

						int lastSchoolNameLength = lastSchoolName.length();

						for (int i = 0; i < 55; i++) {
							if (i < lastSchoolNameLength) {
								out.print("<span class='underline-space'>" + lastSchoolName.charAt(i) + "</span>");
							} else {
								out.print("<span class='underline-space'>&nbsp;</span>");
							}
						}
						%>
				</span> Class: <span class="underline">
						<%
						String lastSchoolClass = (String) request.getAttribute("lastSchoolClass");
						if (lastSchoolClass == null) {
							lastSchoolClass = "";
						}

						int lastSchoolClassLength = lastSchoolClass.length();

						for (int i = 0; i < 8; i++) {
							if (i < lastSchoolClassLength) {
								out.print("<span class='underline-space'>" + lastSchoolClass.charAt(i) + "</span>");
							} else {
								out.print("<span class='underline-space'>&nbsp;</span>");
							}
						}
						%>
				</span>
			</div>
			<div class="space">
				<span>Date of Admission: <span class="underline">&nbsp&nbsp&nbsp&nbsp&nbsp
						<%=request.getAttribute("dateOfAdmission")%>&nbsp&nbsp&nbsp&nbsp&nbsp
				</span>
				</span> <span>Class of Admission: <span class="underline">
						<%
						String classOfAdmission = (String) request.getAttribute("classOfAdmission");
						if (lastSchoolClass == null) {
							lastSchoolClass = "";
						}

						int classOfAdmissionLength = classOfAdmission.length();

						for (int i = 0; i < 8; i++) {
							if (i < classOfAdmissionLength) {
								out.print("<span class='underline-space'>" + classOfAdmission.charAt(i) + "</span>");
							} else {
								out.print("<span class='underline-space'>&nbsp;</span>");
							}
						}
						%>
				</span></span>
			</div>
			<div class="space">
				<span>Progress in Studying:
					Satisfactory__________________________</span> <span>Conduct:
					Good____________</span>
			</div>
			<div class="space">
				<span>Date of Leaving School: ____________</span> <span>Std.
					in which Studying & Since When: ______________</span>
			</div>
			<div class="space">
				<span>Reason for Leaving
					School:_______________________________________________________&nbsp&nbsp&nbsp</span>

			</div>
			<div class="space">
				<span>Remarks:______________________________________________________________________
				</span>
			</div>
		</div>
		<div class="footer">Certificate that the above information is
			correct in accordance with the school Register.</div>


		<div class="bottom">
			<div class="sign">Date: ..../..../20...</div>
			<div class="sign">Class Teacher</div>
			<div class="sign">Clerk</div>
			<div class="sign">Head Master/Principal</div>
		</div>
	</div>
</body>
</html>
