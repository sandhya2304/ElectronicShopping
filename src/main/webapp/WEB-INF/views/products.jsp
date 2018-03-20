<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>   


<head>
  <link src="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style.css  >"/>
</head>
<div id="errors">
  ${exception }
</div>

<div id="formProd" class="cadre">
  <f:form action="saveProd" modelAttribute="product" method="post" enctype="multipart/form-data">
      <table>
         <tr>
           <td>ID Product:</td>
           <td><f:input path="idProduct"/>   </td>
           <td><f:errors path="idProduct" cssClass="errors" />
         </tr>
         <tr>
           <td>designation:</td>
           <td><f:input path="designation"/>   </td>
           <td><f:errors path="designation" cssClass="errors" />
         </tr>
         <tr>
            <td>Categorie</td>
            <td><f:select path="categorie.idCategorie" items="${categories}" itemValue="idCategorie"
          itemLabel="nameCategory"></f:select>
         </tr> 
         <tr>
           <td>description:</td>
           <td><f:input path="description"/>   </td>
           <td><f:errors path="description" cssClass="errors" />
         </tr>
          <tr>
           <td>description:</td>
           <td><f:textarea path="price"/>   </td>
           <td><f:errors path="price" cssClass="errors" />
         </tr>
         <tr>
           <td>price:</td>
           <td><f:input path="price"/>   </td>
           <td><f:errors path="price" cssClass="errors" />
         </tr>
         <tr>
           <td>quantity:</td>
           <td><f:input path="quantity"/>   </td>
           <td><f:errors path="quantity" cssClass="errors" />
         </tr>
         <tr>
           <td>selected:</td>
           <td><f:checkbox path="selected"/>  </td>
           <td><f:errors path="selected" cssClass="errors" />
         </tr>
         <tr>
           <td>Photo:</td>
           <td>
             <c:if test="${product.idProduct!=null }">
                  <img src="/photoProd?idProd=${product.idProduct}" />
             </c:if>
             <input type="file" name="file" />   </td>
         </tr>
         <tr>
           <td><input type="submit" value="saveCategory" />  </td>
         </tr>
      </table>
     
  </f:form>

</div>
<!-- -------------------list of Product  1:56------------------------- -->
<div id="tabProduct" class="cadre">
  <table>
     <tr>
       <th>ID:</th><th>Name:</th><th>Designation:</th><th>Description:</th><th>Price:</th>
       <th>Selected:</th><th>Quantity:</th><th>photo</th>
     </tr>
     <c:forEach items="${listProduct}" var="list">
       <tr>
         <td>${list.idProduct}</td>
         <td>${list.designation}</td>
         <td>${list.description}</td>
          <td>${list.price}</td>
           <td>${list.selected}</td>
            <td>${list.quantity}</td>
     
         <td>
            <img  src="/photoProd?idProd=${list.idProduct}" />
         </td>
         
         <td><a href="deleteProd?idProd=${list.idProduct}">delete</a> </td>
         <td><a href="editProd?idProd=${list.idProduct}">edit</a>  </td>
       </tr>
     </c:forEach>
  </table>

</div>
