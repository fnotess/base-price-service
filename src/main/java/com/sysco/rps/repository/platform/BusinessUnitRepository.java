package com.sysco.rps.repository.platform;

import com.sysco.rps.entity.masterdata.BusinessUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Repository used to load business unit info
 *
 * @author Tharuka Jayalath
 * @copyright (C) 2020, Sysco Corporation
 * @end Created : 6/21/20. Sun 2020 10:50
 */
@Repository
public class BusinessUnitRepository {

    @Value("${active.business.units}")
    private String businessUnitsStr;

    private List<BusinessUnit> businessUnits;
    private Set<String> businessUnitSet;

    /**
     * Constructor
     */
    @Autowired
    public BusinessUnitRepository() {
        super();
        businessUnits = new ArrayList<>();
        businessUnitSet = new HashSet<>();
    }

    public List<BusinessUnit> getBusinessUnitList() {
        // TODO: Retrieve business units from a different source (e.g. a DB table)

        if (businessUnits.isEmpty()) {
            String[] businessUnitIds = businessUnitsStr.split(",");

            for (String businessUnitId : businessUnitIds) {
                BusinessUnit businessUnit = new BusinessUnit(businessUnitId);
                businessUnits.add(businessUnit);
                businessUnitSet.add(businessUnitId);
            }
        }

        return businessUnits;
    }

    public boolean isOpcoExist(String requestedOpCoId) {
        return businessUnitSet.contains(requestedOpCoId);
    }
}
