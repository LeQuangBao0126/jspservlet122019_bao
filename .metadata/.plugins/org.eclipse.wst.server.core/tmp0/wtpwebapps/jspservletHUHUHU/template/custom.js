// them toa nhà
$("#btnThemToaNha").click(function(e) {

    e.preventDefault();
    // call api them toa nhà.
    var data = {};
    var buildingTypes = [];
    var formData = $("#forminsert").serializeArray(); //chứa tất cả dữ liệu trong forminsert .. phải loop nó

    $.each(formData, function(index, v) {
        if (v.name == 'buildingTypes') {
            buildingTypes.push(v.value);
        } else {
            data[v.name] = v.value;
        }
    });
    data['buildingTypes'] = buildingTypes;
    // console.log(data);
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api-building",
        data: JSON.stringify(data),
        dataType: "json",
        contentType: "application/json",
        success: function(response) {
            console.log("sucess");
            Swal.fire({
                icon: 'success',
                title: 'Thêm toà nhà thành công',
                timer: 1000
            })

            console.log(response);
        },
        error: function(response) {
            console.log("fail");
            console.log(response);
        }
    });
});

//Giao toà nhà cho nhan viên// api show staff 
function showStaffAssignment(buildingid) {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api-user?action=LOAD_STAFF&buildingId=" + buildingid,
        dataType: "json",
        success: function(users) {
            console.log(users);
            var html = '';
            for (var i = 0; i < users.length; i++) {
                html += `<tr>
                <td><input type="checkbox" value="${users[i].id}" id="checkbox_${users[i].id}" ${users[i].checked=='checked'?'checked':''}  ></td>
                <td>${users[i].fullName}</td>
                </tr>`;
            }

            $("#staffList tbody").html(html);
        },
        error: function() {

        }
    });
}

function Assignmentbuilding(buildingid) {
    $("#assignmentbuildingmodal").modal();
    $("#buildingid").val(buildingid);
    showStaffAssignment($("#buildingid").val());
}
$("#btnAssignBuilding").click(function(e) {
    e.preventDefault();
    var data = {};
    var buildingId = $("#buildingid").val();
    var staffIds = [];

    var staffListId = $("#staffList").find('tbody input[type=checkbox]:checked').map(function() {
        return $(this).val();
    }).get();

    data['staffIds'] = staffListId;
    data['buildingId'] = buildingId;
    //call api giao toà nhà cho nhan vien
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api-assignmentbuilding",
        data: data,
        dataType: "json",
        contentType: "application/json",
        success: function(response) {
            console.log("sucess");
        },
        error: function(response) {
            console.log("fail");
        }
    });
});

//xoá toà nhà
$("#btnDeleteBuildings").click(function(e) {
    e.preventDefault();
    var data = {};
    var buildingIds = $("#buildingList").find('tbody input[type=checkbox]:checked').map(function() {
        return $(this).val();
    }).get();
    if (buildingIds.length < 1) {
        alert("bạn chưa chọn toà nhà");
        return 0;
    }
    data['buildingIds'] = buildingIds;
    var thongbao = confirm("Bạn có chắc chắn muốn xoá ");
    if (thongbao == true) {
        //gọi ajax xoá toà nhà
        $.ajax({
            type: "DELETE",
            url: "http://localhost:8080/api-building",
            data: JSON.stringify(data),
            dataType: "json",
            contentType: "application/json",
            success: function(response) {
                console.log("sucess");
            },
            error: function(response) {
                console.log("fail");
            }
        });
        var i;
        for (i = 0; i < buildingIds.length; i++) {
            document.getElementById(`tr_${buildingIds[i]}`).remove();
        }
    }

});