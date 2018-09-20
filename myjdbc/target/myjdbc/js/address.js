
   	$(document).ready(function(){
			// Custom method to validate username
			$("#submit").click(function(){
				var form = $("#myform");
				form.validate({
					errorElement: 'span',
					errorClass: 'help-block',
					highlight: function(element, errorClass, validClass) {
						$(element).closest('.form-group').addClass("has-error").focus();
					},
					unhighlight: function(element, errorClass, validClass) {
						$(element).closest('.form-group').removeClass("has-error").addClass("has-true");
					},
					rules: {
						password : {
							required: true,
							minlength: 6,
							maxlength: 15,
						},
						conf_password : {
							required: true,
							equalTo: '#password',
						},
						email: {
							required: true,
							minlength: 3,
						},
						firstName: {
							required: true,
							minlength: 3,
						},
						lastName: {
							required: true,
							minlength: 3,
						},
						dateOfBirth: {
							required: true,
						},
						gender: {
							required: true,
						},
						mobileNo: {
							required: true,
							minlength: 10,
						},
						alternateNo: {
							required: false,
							minlength: 10,
						},
						upfile: {
							required: true,
						},
						line: {
							required: true,
							minlength: 3,
						},
						street: {
							required: true,
							minlength: 3,
						},
						area: {
							required: true,
							minlength: 3,
						},
						landmark: {
							required: true,
							minlength: 3,
						},
						city: {
							required: true,
						},
						state: {
							required: true,
						},
						country: {
							required: true,
						},
						pincode: {
							required: true,
							minlength: 6,
						},
					},
					messages: {
						password : {
							required: "Password required",
						},
						conf_password : {
							required: "Password required",
							equalTo: "Password don't match",
						},
						email: {
							required: "Email required",
						},
						firstName: {
							required: "First Name required",
						},
						lastName: {
							required: "Last Name required",
						},
						gender: {
							required: "Gender required",
						},
						dateOfBirth: {
							required: "Date Of Birth required",
						},
						mobileNo: {
							required: "Mobile No required",
						},
						upfile: {
							required: "File select required",
						},
						line: {
							required: "Address Line required",
						},
						street: {
							required: "Street required",
						},
						area: {
							required: "Area required",
						},
						city: {
							required: "City required",
						},
						state: {
							required: "State required",
						},
						country: {
							required: "Country required",
						},
						pincode: {
							required: "Pincode required",
						},
					}
				});
				if (form.valid() === true){
					if ($('#account_information').is(":visible")){
						current_fs = $('#account_information');
						next_fs = $('#personal_information');
					}
					next_fs.show(); 
					current_fs.hide();
				}
			});

			$('#previous').click(function(){
				if($('#personal_information').is(":visible")){
					current_fs = $('#personal_information');
					next_fs = $('#account_information');
				}
				next_fs.show(); 
				current_fs.hide();
			});
            
    //@naresh action dynamic childs
    var next_exp = 0;
    $("#add-more1").click(function(e){
        e.preventDefault();
        var addto = "#fielda" + next_exp;
        var addRemove = "#fielda" + (next_exp);
        next_exp = next_exp + 1;
        var newInp = 
        		' <div id="fielda'+ next_exp +'" name="field1'+ next_exp +'"><div class="form-group"><label>Line</label><input type="text" name="line[]" id="line" class="form-control" placeholder="Address Line" required></div><div class="form-group"><label>Street</label><input type="text" name="street[]" id="street" class="form-control" placeholder="Street" required></div><div class="form-group"><label>Area</label><input type="text" name="area[]" id="area" class="form-control" placeholder="Area" required></div><div class="form-group"><label>Landmark</label><input type="text" name="famous[]" id="landmark" class="form-control" placeholder="Landmark" required></div><div class="form-group"><label>City</label><input type="text" name="city[]" id="city" class="form-control" placeholder="City" required></div><div class="form-group"><label>State</label><input type="text" name="state[]" id="state" class="form-control" placeholder="State" required></div><div class="form-group"><label>Country</label><input type="text"  name="country[]" id="country" class="form-control" placeholder="Country" required></div><hr></div>';
        var newInput = $(newInp);
        var removeBtn = '<button id="remove' + (next_exp - 1) + '" class="btn btn-danger remove-me" >Remove</button></div></div><div id="field"><br>';
        var removeButton = $(removeBtn);
        $(addto).after(newInput);
        $(addRemove).after(removeButton);
        $("#fielda" + next_exp).attr('data-source',$(addto).attr('data-source'));
        $("#count").val(next_exp);  
        
            $('.remove-me').click(function(e){
                e.preventDefault();
                var fieldNum = this.id.charAt(this.id.length-1);
                var fieldID = "#fielda" + fieldNum;
                $(this).remove();
                $(fieldID).remove();
            });
    });			
		});