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

package org.omg.dss.evaluation;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import org.omg.dss.common.ServiceRequestBase;
import org.omg.dss.evaluation.requestresponse.IterativeEvaluationRequest;


/**
 * <p>Java class for evaluateIteratively complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="evaluateIteratively">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.omg.org/spec/CDSS/201105/dss}ServiceRequestBase">
 *       &lt;sequence>
 *         &lt;element name="iterativeEvaluationRequest" type="{http://www.omg.org/spec/CDSS/201105/dss}IterativeEvaluationRequest"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "evaluateIteratively", propOrder = {
    "iterativeEvaluationRequest"
})
public class EvaluateIteratively
    extends ServiceRequestBase
{

    @XmlElement(required = true)
    protected IterativeEvaluationRequest iterativeEvaluationRequest;

    /**
     * Gets the value of the iterativeEvaluationRequest property.
     *
     * @return
     *     possible object is
     *     {@link IterativeEvaluationRequest }
     *
     */
    public IterativeEvaluationRequest getIterativeEvaluationRequest() {
        return iterativeEvaluationRequest;
    }

    /**
     * Sets the value of the iterativeEvaluationRequest property.
     *
     * @param value
     *     allowed object is
     *     {@link IterativeEvaluationRequest }
     *
     */
    public void setIterativeEvaluationRequest(IterativeEvaluationRequest value) {
        this.iterativeEvaluationRequest = value;
    }

}
