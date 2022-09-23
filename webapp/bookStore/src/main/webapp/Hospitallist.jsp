<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Hospital System</title>
</head>
<body>
    <center>
        <h1>Hospital Management System</h1>
        <h2>
            <a href="/new">Add New Hospital</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/list">List All  Hospitals</a>
        </h2>
    </center>
    <div align="center">
        <c:if test="${book != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${book == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${ Hospital != null}">
                        Edit Book
                    </c:if>
                    <c:if test="${ Hospital == null}">
                        Add New  Hospital
                    </c:if>
                </h2>
            </caption>
                <c:if test="${ Hospital != null}">
                    <input type="hidden" name="hospital_id" value="<c:out value='${ Hospital.hospital_id}' />" />
                </c:if>           
            <tr>
                <th>hospital_name: </th>
                <td>
                    <input type="text" name="hospital_name" size="45"
                            value="<c:out value='${Hospital.title}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Address: </th>
                <td>
                    <input type="text" name="address" size="45"
                            value="<c:out value='${Hospital.address}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>conno: </th>
                <td>
                    <input type="text" name="conno" size="10"
                            value="<c:out value='${Hospital.conno}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>