package com.codehub.pf.team4.mappers;

import com.codehub.pf.team4.domains.Repair;
import com.codehub.pf.team4.domains.User;
import com.codehub.pf.team4.enums.RepairType;
import com.codehub.pf.team4.enums.State;
import com.codehub.pf.team4.forms.RepairForm;
import com.codehub.pf.team4.utils.DateProvider;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class RepairFormMapper {

    public static Repair mapToRepair(RepairForm repairForm) throws Exception {
        if(repairForm == null) return null;

        Repair repair = new Repair();
        repair.setDate(DateProvider.getLocalDate(repairForm.getDate()));
        repair.setAddress(repairForm.getAddress());
        repair.setRepairType(RepairType.valueOf(repairForm.getRepairType()));
        repair.setState(State.valueOf(repairForm.getState()));
        repair.setCost(Long.parseLong(repairForm.getCost()));
        repair.setDescription(repairForm.getDescription());
        repair.setUser((new User()));
        repairForm.setUserId((repairForm.getUserId()));

        repair.getUser().setId(Long.parseLong(repairForm.getUserId()));

        if(!repairForm.getId().isEmpty()) {
            repair.setId(Long.parseLong(repairForm.getId()));
        }

        return repair;
    }

    public static RepairForm mapToRepairForm(Repair repair) throws Exception {
        if(repair == null) return null;

        RepairForm repairForm = new RepairForm();
        repairForm.setDate(repair.getDate().format(DateProvider.getFormat()));
        repairForm.setAddress(repair.getAddress());
        repairForm.setRepairType(repair.getRepairType().toString());
        repairForm.setState(repair.getState().toString());
        repairForm.setCost(repair.getCost().toString());
        repairForm.setDescription(repairForm.getDescription());
        repairForm.setUserId((repair.getUser().getId().toString()));
        repairForm.setId(repair.getId().toString());

        return repairForm;
    }
}
