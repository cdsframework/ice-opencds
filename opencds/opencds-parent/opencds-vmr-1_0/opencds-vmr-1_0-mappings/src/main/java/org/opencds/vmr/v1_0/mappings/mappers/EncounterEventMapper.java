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

package org.opencds.vmr.v1_0.mappings.mappers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.opencds.common.exceptions.DataFormatException;
import org.opencds.common.exceptions.ImproperUsageException;
import org.opencds.common.exceptions.InvalidDataException;
import org.opencds.vmr.v1_0.internal.EncounterEvent;
import org.opencds.vmr.v1_0.internal.datatypes.IVLDate;
import org.opencds.vmr.v1_0.mappings.in.FactLists;
import org.opencds.vmr.v1_0.mappings.out.structures.OrganizedResults;
import org.opencds.vmr.v1_0.mappings.utilities.MappingUtility;

/*
 * Mapper classes provide mapping in both directions between the external schema structure of the vMR
 * 		and the internal javabeans used by the rules.
 * 
 * @author Daryl Chertcoff
 *
 */
public class EncounterEventMapper extends EncounterBaseMapper {

	private static Log logger = LogFactory.getLog(EncounterEventMapper.class);
	
	/**
	 * @param external
	 * @param internal
	 * @param subjectPersonId
	 * @param focalPersonId
	 * @param factLists
	 * @throws ImproperUsageException
	 * @throws DataFormatException
	 * @throws InvalidDataException
	 */
	public static void pullIn(
			org.opencds.vmr.v1_0.schema.EncounterEvent 		external, 
			EncounterEvent 									internal, 
			String											subjectPersonId, 
			String											focalPersonId, 
			FactLists 										factLists
			) throws ImproperUsageException, DataFormatException, InvalidDataException {
		
		String _METHODNAME = "pullIn(): ";
		
		if (external == null) {
			return;
		}
	
		try {
			EncounterBaseMapper.pullIn(external, internal, subjectPersonId, focalPersonId, factLists);
		}
		catch (ImproperUsageException u) {
			String errStr = _METHODNAME + "Caught unexpected ImproperUsageException: " + u.getMessage();
			logger.error(errStr, u);
			throw new RuntimeException(errStr);
		}
		
		if ( external.getEncounterEventTime() == null ) {
		    throw new InvalidDataException("EncounterEventTime was null");
		}
		IVLDate eet = MappingUtility.iVLTS2IVLDateInternal(external.getEncounterEventTime());
		if (eet == null) {
		    throw new InvalidDataException("EncounterEventTime was invalid.");
		} else if (eet.getLow() == null && eet.getHigh() == null) {
		    throw new InvalidDataException("EncounterEventTime must have non-null low or high value");
		}
		internal.setEncounterEventTime(eet);

		factLists.put(EncounterEvent.class, internal);
		
		// pull in nested RelatedEntities and RelatedClinicalStatements
		NestedObjectsMapper.pullInClinicalStatementNestedObjects(external, internal.getId(), subjectPersonId, focalPersonId, factLists);
		
		return;
	}
	
	
	/**
	 * Populate external vMR object from corresponding internal vMR object; if supplied source parameter is null, simply returns
	 * 
	 * @param source
	 * @param target
	 * @param organizedResults
	 * @return
	 * @throws ImproperUsageException
	 * @throws DataFormatException
	 * @throws InvalidDataException
	 */
	public static org.opencds.vmr.v1_0.schema.EncounterEvent pushOut(
			EncounterEvent 									source, 
			org.opencds.vmr.v1_0.schema.EncounterEvent 		target, 
			OrganizedResults								organizedResults
		) throws ImproperUsageException, DataFormatException, InvalidDataException {
		
		String _METHODNAME = "pushOut(): ";
		
		if (source == null)
			return null;
		
		target = new org.opencds.vmr.v1_0.schema.EncounterEvent();
		
		try {
			EncounterBaseMapper.pushOut(source, target);
		}
		catch (ImproperUsageException u) {
			String errStr = _METHODNAME + "Caught unexpected ImproperUsageException: " + u.getMessage();
			logger.error(errStr, u);
			throw new RuntimeException(errStr);
		}
		
		if ( source.getEncounterEventTime() != null ) target.setEncounterEventTime(MappingUtility.iVLDateInternal2IVLTS(source.getEncounterEventTime()));

		// look for and add any nested RelatedClinicalStatements and nested RelatedEntities
		target = NestedObjectsMapper.pushOutClinicalStatementNestedObjects(source, target, organizedResults);
		
		if (organizedResults.getOutput().getEncounterEvents() == null) {
			organizedResults.getOutput().setEncounterEvents(new org.opencds.vmr.v1_0.schema.EvaluatedPerson.ClinicalStatements.EncounterEvents());
		}
		
		return target;
	}
}
