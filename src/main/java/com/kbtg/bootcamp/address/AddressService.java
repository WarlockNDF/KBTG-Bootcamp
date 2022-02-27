package com.kbtg.bootcamp.address;

import com.kbtg.bootcamp.address.dto.AddressRequestDTO;
import com.kbtg.bootcamp.entities.User;
import com.kbtg.bootcamp.entities.UserAddress;
import com.kbtg.bootcamp.exception.exceptions.FailedToDeleteDataException;
import com.kbtg.bootcamp.exception.exceptions.FailedToSaveDataException;
import com.kbtg.bootcamp.exception.exceptions.NoSuchAddressException;
import com.kbtg.bootcamp.exception.exceptions.UserNotFoundException;
import com.kbtg.bootcamp.users.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final UserService userService;

    public List<UserAddress> getListOfAddress(Integer id) {
        List<UserAddress> userAddressList = addressRepository.findAllByUserId(id);
        if (userAddressList.isEmpty()){
            throw new UserNotFoundException("User Not Exist In the System");
        }
        return userAddressList;
    }

    public UserAddress saveUserAddress(AddressRequestDTO address, Integer userId) {
        UserAddress userAddress = addressRepository.save(convertToEntity(address,userId));
        if(addressRepository.findById(userAddress.getId()).isEmpty()){
            throw new FailedToSaveDataException("Failed To Save Address");
        }
        return userAddress;
    }

    public UserAddress updateUserAddress(AddressRequestDTO address, Integer userId) {
        if(!addressRepository.existsById(address.getId())){
            throw new NoSuchAddressException("No Such Address");
        }
        return saveUserAddress(address,userId);
    }

    public Object deleteUserAddress(Integer addressId, Integer userId) {
        Optional<UserAddress> userAddress = addressRepository.findById(addressId);
        if(userAddress.isEmpty() || (!Objects.equals(userAddress.get().getUser().getId(), userId))) {
            throw new FailedToDeleteDataException("No Such Address or No Credential");
        }
        addressRepository.deleteById(addressId);
        if(addressRepository.findById(addressId).isPresent()){
            throw new FailedToDeleteDataException("Failed To Delete UserAddress");
        }
        return Map.of(

        );
    }

    //TODO REFACTOR WHEN IMPLEMENT AUTHENTICATION
     private UserAddress convertToEntity(AddressRequestDTO requestDTO, Integer userId){
        Optional<User> user = userService.getRepo().findById(userId);
        if(user.isEmpty()){
            throw new UserNotFoundException("User Not Exist In the System");
        }
        return requestDTO.toEntity(user.get());
    }

    public AddressRepository getRepo(){
        return addressRepository;
    }

}