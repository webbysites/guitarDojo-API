package com.guitardojo.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.guitardojo.api.models.StaffMember;

public interface StaffMemberRepository extends MongoRepository<StaffMember, String> {

}
