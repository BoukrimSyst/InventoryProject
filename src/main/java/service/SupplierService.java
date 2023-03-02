package service;


import com.example.demo.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.SupplierRepository;

import java.util.List;
import java.util.UUID;

@Service
public class SupplierService {

    private static SupplierRepository supplierRepository;


    @Autowired
    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<Supplier> findAllSuppliers(){
        return supplierRepository.findAll();
    }

    public static Supplier findSupplierById(Long id){
        return supplierRepository.findSupplierById(id)
                .orElseThrow(() -> new RuntimeException("User by Id "+ id +"was not found"));

    }

    public Supplier addSupplier(Supplier supplier){
        supplier.setSupplierID(Long.valueOf(UUID.randomUUID().toString()));
        return supplierRepository.save(supplier);
    }



    public void deleteSupplier(Long id){
        supplierRepository.deleteSupplierById(id);
    }

    public Supplier updateSupplier(Supplier supplier){
        return supplierRepository.save(supplier);
    }
}
