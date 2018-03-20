<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>   


<head>
  <link src="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style.css  >"/>
</head>
<div id="errors">
  ${exception }
</div>

<div id="formCat" class="cadre">
  <f:form action="saveCat" modelAttribute="category" method="post" enctype="multipart/form-data">
      <table>
         <tr>
           <td>IDCategorie:</td>
           <td><f:input path="idCategorie"/>   </td>
           <td><f:errors path="idCategorie" cssClass="errors" />
         </tr>
         <tr>
           <td>Name Categorie:</td>
           <td><f:input path="nameCategory"/>   </td>
           <td><f:errors path="nameCategory" cssClass="errors" />
         </tr>
         <tr>
           <td>description:</td>
           <td><f:input path="description"/>   </td>
           <td><f:errors path="description" cssClass="errors" />
         </tr>
         <tr>
           <td>Photo:</td>
           <td>
             <c:if test="${categorie.idCategorie!=null }">
                  <img src="/photoCat?idCat=${list.idCategorie}" />
             </c:if>
             <input type="file" name="file" />   </td>
         </tr>
         <tr>
           <td><input type="submit" value="saveCategory" />  </td>
         </tr>
      </table>
     
  </f:form>

</div>
<!-- -------------------list of category-------------------------- -->
<div id="listCategory">
  <table>
     <tr>
       <th>ID:</th><yh>Name:</yh><th>Descritpion:</th><th>photo</th>
     </tr>
     <c:forEach items="${listCategory}" var="list">
       <tr>
         <td>${list.idCategorie}</td>
         <td>${list.nameCategory}</td>
         <td>${list.description}</td>
         <td>${list.photo}</td>
         <td>
            <img  src="/photoCat?idCat=${list.idCategorie}" />
         </td>
         <td><a href="deleteCat?idCat=${list.idCategorie}">delete</a> </td>
         <td><a href="editCat?idCat=${list.idCategorie}">edit</a>  </td>
       </tr>
     </c:forEach>
  </table>

</div>
