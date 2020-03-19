<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trang chủ</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs ace-save-state" id="breadcrumbs">
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Trang chủ</a>
                </li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
                    <div class="row">
                        <div class="widget-box">
                            <div class="widget-header">
                                <h4 class="widget-title">Tìm Kiếm</h4>
                                <div class="widget-toolbar">
                                    <a href="#" data-action="collapse">
                                        <i class="ace-icon fa fa-chevron-up"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="widget-body">
                                <div class="widget-main">
                                    <div class="row">
                                        <div class="col-xs-12">
                                            <!-- PAGE CONTENT BEGINS -->
                                            <form action="admin-building?action=search" method="POST" id="formSearchBuilding">
                                            <div class="row">
                                                <div class="col-sm-6">
                                                    <div>
                                                        <label for="name"> Tên Toà Nhà </label>
                                                        <input type="text" id="name" name="name" class="form-control" />
                                                    </div>
                                                </div>
                                                <div class="col-sm-6">
                                                    <div>
                                                        <label for=""> Diện Tích Sàn </label>
                                                        <input type="number" id="floorarea" name="floorArea" class="form-control" />
                                                    </div>
                                                </div>
                                                <div class="col-sm-4">
                                                    <label for="">Quận Huyện</label>
                                                    <select class="form-control" id="district" name="district">
														<option value="">--Chọn Quận Huyện--</option>
														<option value="QUAN_1">Quận 1</option>
														<option value="QUAN_2">Quận 2</option>
														<option value="QUAN_3">QUận 3</option>
														<option value="QUAN_4">QUận 4</option>
													</select>
                                                </div>
                                                <div class="col-sm-4">
                                                    <label for="">Phường</label>
                                                    <input type="text" id="ward" name="ward" class="form-control" />
                                                </div>
                                                <div class="col-sm-4">
                                                    <label for="">Đường</label>
                                                    <input type="text" id="street" name="street" class="form-control" />
                                                </div>
                                                <div class="col-sm-4">
                                                    <label for="">Số Tầng Hầm</label>
                                                    <input type="number" id="numberOfBasement" name="numberOfBasement" class="form-control" />
                                                </div>
                                                <div class="col-sm-4">
                                                    <label for="">Hướng</label>
                                                    <input type="text" id="direction" class="form-control" />
                                                </div>
                                                <div class="col-sm-4">
                                                    <label for="">Hạng</label>
                                                    <input type="text" id="level" class="form-control" />
                                                </div>
                                                <div class="col-sm-3">
                                                    <label for="">Diện tích thuê từ</label>
                                                    <input type="number" id="rentAreaFrom" name="rentAreaFrom" class="form-control" />
                                                </div>
                                                <div class="col-sm-3">
                                                    <label for="">Diện tích thuê đến</label>
                                                    <input type="number" id="rentAreaTo" name="rentAreaTo" class="form-control" />
                                                </div>
                                                <div class="col-sm-3">
                                                    <label for="">Giá thuê từ</label>
                                                    <input type="number" id="rentCostFrom" name="rentCostFrom" class="form-control" />
                                                </div>
                                                <div class="col-sm-3">
                                                    <label for="">Giá thuê đến</label>
                                                    <input type="number" id="rentCostTo" name="rentCostTo" class="form-control" />
                                                </div>
                                                <div class="col-sm-4">
                                                    <label for="">Tên quản lý</label>
                                                    <input type="text" id="managerName" name="managerName" class="form-control" />
                                                </div>
                                                <div class="col-sm-4">
                                                    <label for="">Điện thoại quản lý</label>
                                                    <input type="text" id="managerPhone" name="managerPhone" class="form-control" />
                                                </div>
                                                <div class="col-sm-3">
                                                    <label for="">Chọn nhân viên phụ trách</label>
                                                    <select class="form-control" name="staffId" >
														<option value="-1">--Chọn Nhân Viên Phụ Trách--</option>
														<option value="1">aa</option>
														<option value="2">bb</option>
														<option value="3">cc</option>
													</select>
                                                </div>
                                                       <div class="col-sm-12">
                                                    <div class="control-group">
                                                        <label class="control-label bolder blue">Loại toà nhà</label>
                                                        <div class="checkbox" >
                                                            <label>
																<input name="buildingTypes" value="TANG_TRET" type="checkbox" class="ace">
																<span class="lbl">Tầng Trệt</span>
															</label>
		                                                            <label>
																<input name="buildingTypes" value="NGUYEN_CAN" type="checkbox" class="ace">
																<span class="lbl">Nguyên Căn</span>
															</label>
		                                                            <label>
																<input name="buildingTypes" value="NOI_THAT" type="checkbox" class="ace">
																<span class="lbl">Nội Thất</span>
															</label>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-sm-12">
                                                    <div class="pull-left" data-toggle="tooltip" title="Thêm Toà Nhà">
                                                        <button id="btnSearchBuilding" type="submit" class="btn btn-sucess btn-info btn-bold" >
											           	Tìm Kiếm
											           </button>
                                                    </div>
                                                </div>

                                            </div>
											</form>
                                            <!-- PAGE CONTENT ENDS -->
                                        </div>
                                        <!-- /.col -->
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="pull-left" data-toggle="tooltip" title="Thêm Toà Nhà">
                            <a href="admin-building-insert" class="btn btn-sucess btn-info btn-bold" >
									<i class="ace-icon glyphicon glyphicon-plus"></i>
									Thêm
								</a>
                        </div>
                        <div class="pull-left"  title="Xoá Nhiều Toà Nhà">
                            <button class="btn btn-danger btn-info btn-bold" id="btnDeleteBuildings">
									<i class="ace-icon fa fa-trash-o icon-only"></i>
									Xoá
							</button>
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <table id="buildingList" class="table table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th></th>
                                            <th>Tên Toà Nhà</th>
                                            <th>Địa Chỉ</th>
                                            <th>Tên Quản Lý</th>
                                            <th>Số Điện Thoại</th>
                                            <th>Diện Tích Sàn</th>
                                            <th>Giá Thuê</th>
                                            <th>Loại toà nhà</th>
                                            <th>Thao Tác</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                   	<c:forEach items="${list}" var="item">
                                   	  <tr>
                                            <td class="center">
                                                <input type="checkbox" value="${item.id }" id="checkbox_${item.id}" />
                                            </td>
                                            <td>${item.name}</td>
                                            <td>${item.street}</td>
                                            <td>${item.managerName}</td>
                                            <td>${item.managerPhone}</td>
                                            <td>${item.floorarea}</td>
                                            <td>${item.rentCost}</td>
                                            <td>${item.type}</td>
                                            <td>
                                                <div class="hidden-sm hidden-xs btn-group">
                                                    <button class="btn btn-xs btn-success"
                                                     title="giao toà nhà"                                                   
                                                     onclick="Assignmentbuilding(2)"
                                                      >
																<i class="ace-icon fa fa-check bigger-120"></i>
													</button>

                                                    <a href="admin-building-edit" class="btn btn-xs btn-info" title="Sửa toà nhà">
																<i class="ace-icon fa fa-pencil bigger-120"></i>
													</a>
                                                </div>
                                            </td>
                                        </tr> 
                                   	</c:forEach>
                                      
                                                                               
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <!-- /.row -->
                </div>
                <!-- /.page-content -->
    </div>
    
</div><!-- /.main-content -->


<!-- Modal -->
<div class="modal fade" id="assignmentbuildingmodal" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
      </div>
      <div class="modal-body">
      <h3>Tích để giao toà nhà cho nhân viên</h3>
        <table id="staffList" > 
        	<thead>
        		<tr>Chọn nhan viên</tr>
        		<tr>Tên nhan vien</tr>
        	</thead>
        	<tbody>
        		<tr>
        			<td><input type="checkbox" value="1" id="checkbox_1" checked ></td>
        			<td>Nguyễn văn a</td>
        		</tr>
        		<tr>
        			<td><input type="checkbox" value="2" id="checkbox_2" checked ></td>
        			<td>Nguyễn văn b</td>
        		</tr>
        		<tr>
        			<td><input type="checkbox" value="3" id="checkbox_3" checked ></td>
        			<td>Nguyễn văn c</td>
        		</tr>
        	</tbody>
        </table>      
 	 	<input type="hidden" value="" name="buildingid" id="buildingid"/>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" id="btnAssignBuilding">Giao</button>
      </div>
    </div>
  </div>
</div>

</body>
</html>