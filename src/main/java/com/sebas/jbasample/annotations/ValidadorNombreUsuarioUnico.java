
package com.sebas.jbasample.annotations;

import com.sebas.jbasample.repository.UsuarioRepository;
import com.sebas.jbasample.service.UserService;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author sgerman
 */
public class ValidadorNombreUsuarioUnico implements ConstraintValidator<NombreUsuarioUnico, String>{
    @Autowired
    UserService userService;
//    UsuarioRepository usuarioRepository;
    
    
    @Override
    public void initialize(NombreUsuarioUnico a) {
    }

    @Override
    public boolean isValid(String nombre, ConstraintValidatorContext cvc) {
//        return usuarioRepository.findOne(nombre) == null;
        if (null == userService){
            return true;
        }
        return userService.findOne(nombre) == null;
    }
    
}
