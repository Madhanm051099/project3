<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <html>

        <head>
            <title>
                Hospital
            </title>
        </head>

        <body>
            <center>
                <h1>Hospital Management</h1>
                <h2>
                    <a href="/new">Add New Hospital</a>
                    &nbsp;&nbsp;&nbsp;
                    <a href="/list">List Of Hospitals</a>
                </h2>
            </center>
            <div align="center">
                <table border="1" cellpadding="5">
                    <caption>
                        <h2>List of Hospitals</h2>
                    </caption>
                    <tr>
                        <th>ID</th>
                        <th>name</th>
                        <th>address</th>
                        <th>conno</th>
                        <th>Actions</th>
                    </tr>
                    <c:forEach var="hospital" items="${hospital}">
                        <tr>
                            <td>
                                <c:out value="${hospital.hospital_id}" />
                            </td>
                            <td>
                                <c:out value="${hospital.hospital_name}" />
                            </td>
                            <td>
                                <c:out value="${hospital.hospital_address}" />
                            </td>
                            <td>
                                <c:out value="${hospital.hospital_conno}" />
                            </td>
                            <td>
                                <a href="/edit?hospital_id=<c:out value='${hospital.hospital_id}' />">Edit</a>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <a href="/delete?hospital_id=<c:out value='${hospital.hospital_id}' />">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </body>

        </html>

