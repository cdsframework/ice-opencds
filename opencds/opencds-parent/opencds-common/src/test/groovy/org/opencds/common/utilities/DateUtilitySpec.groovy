/*
 * Copyright 2016-2020 OpenCDS.org
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

package org.opencds.common.utilities

import spock.lang.Specification

class DateUtilitySpec extends Specification{

	def "is an invalid date format"(){
		when:
		String dateAsString = "20160211172141-0700"
		String formatTemplate = "yyyyMMddHHmmss.SSSZ"

		then:
		DateUtility.instance.isValidDateFormat(dateAsString, formatTemplate) == false

	}

	def "is a valid date format"(){
		when:
		String dateAsString = "20160211172141-0700"
		String formatTemplate = "yyyyMMddHHmmssZ"

		then:
		DateUtility.instance.isValidDateFormat(dateAsString, formatTemplate) == true

	}

}
