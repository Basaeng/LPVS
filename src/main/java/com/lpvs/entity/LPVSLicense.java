/**
 * Copyright (c) 2023, Samsung Electronics Co., Ltd. All rights reserved.
 *
 * Use of this source code is governed by a MIT license that can be
 * found in the LICENSE file.
 */

package com.lpvs.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "licenses", schema = "lpvs", indexes = {@Index(name = "spdx_id", columnList = "license_spdx", unique = true)})
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class LPVSLicense implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long licenseId;

    @Column(name = "license_name", nullable = false)
    private String licenseName;

    @Column(name = "license_spdx", nullable = false)
    private String spdxId;

    @Column(name = "license_usage")
    private String access;

    @Column(name = "license_alternative_names", columnDefinition = "LONGTEXT")
    private String alternativeNames;

    @Transient
    private String checklistUrl;

}
