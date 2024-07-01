<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 상대 경로를 유일하게 쓰는 곳 -->    
<%@include file="../includes/header.jsp" %>

<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Modify/Delete</h1>
        </div>
     
    </div>
  
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    DataTables Advanced Tables
                </div>
              
                <div class="panel-body">
                   <form >
                	<div class="form-group">
                        <label>Bno</label>
                       <input class="form-control" readonly="readonly" name="bno" value='<c:out value="${dto.bno }"/>'>
                    </div>
                    <div class="form-group">
                        <label>Title</label>
                       <input class="form-control" name="title" value='<c:out value="${dto.title }"/>'>
                    </div>
                    <div class="form-group">
                        <label>Content</label>
                      	<textarea class="form-control" rows="5" cols="50" name="content">
                      	<c:out value="${dto.content }"/>
                      	</textarea>
                    </div>
                      <div class="form-group">
                        <label>Writer</label>
                       <input class="form-control" readonly="readonly" name="writer" value='<c:out value="${dto.writer }"/>'>
                    </div>
                       <button type="button" class="btn btn-success"><a href="/board/list">List</a></button>
      				   <button type="button" class="btn btn-warning disabled">Modify</button>
      				   <button type="button" class="btn btn-danger">Delete</button>
           			</form>
                </div>
         
            </div>
    
        </div>

    </div>

</div>

<%@include file="../includes/footer.jsp" %>