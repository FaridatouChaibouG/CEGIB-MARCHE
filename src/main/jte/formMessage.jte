@import org.springframework.validation.BindingResult

@param BindingResult  bindingResult


@param String field
@if(bindingResult != null && bindingResult.hasErrors() && bindingResult.getFieldError(field) != null)
    <small class="text-danger ">
        ${bindingResult.getFieldError(field).getDefaultMessage()}
    </small>
@endif
