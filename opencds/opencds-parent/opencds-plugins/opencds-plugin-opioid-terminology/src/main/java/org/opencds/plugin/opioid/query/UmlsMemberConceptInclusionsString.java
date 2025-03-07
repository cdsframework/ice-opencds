/*
 * Copyright 2020 OpenCDS.org
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

package org.opencds.plugin.opioid.query;

import org.opencds.plugin.opioid.util.AccessConnection;
import org.opencds.plugin.opioid.util.ConsumerUtil;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class UmlsMemberConceptInclusionsString {
	
	public static Set<String> query(AccessConnection conn, String query) throws SQLException {
		Set<String> umlsMemberConceptSet = new HashSet<>();
		conn.executeQuery(query, ConsumerUtil.getConsumerString(umlsMemberConceptSet));
		return umlsMemberConceptSet;
	}
}
