/*
 * Copyright 2011-2020 OpenCDS.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.omg.dss.metadata.profile;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import org.omg.dss.common.EntityIdentifier;


/**
 * This object groups service profiles of a given type.
 *
 * <p>Java class for ProfilesOfType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ProfilesOfType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="type" type="{http://www.omg.org/spec/CDSS/201105/dss}ProfileType"/>
 *         &lt;element name="profileId" type="{http://www.omg.org/spec/CDSS/201105/dss}EntityIdentifier" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProfilesOfType", propOrder = {
    "type",
    "profileId"
})
public class ProfilesOfType {

    @XmlElement(required = true)
    protected ProfileType type;
    @XmlElement(required = true)
    protected List<EntityIdentifier> profileId;

    /**
     * Gets the value of the type property.
     *
     * @return
     *     possible object is
     *     {@link ProfileType }
     *
     */
    public ProfileType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value
     *     allowed object is
     *     {@link ProfileType }
     *
     */
    public void setType(ProfileType value) {
        this.type = value;
    }

    /**
     * Gets the value of the profileId property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the profileId property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProfileId().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityIdentifier }
     *
     *
     */
    public List<EntityIdentifier> getProfileId() {
        if (profileId == null) {
            profileId = new ArrayList<EntityIdentifier>();
        }
        return this.profileId;
    }

}
