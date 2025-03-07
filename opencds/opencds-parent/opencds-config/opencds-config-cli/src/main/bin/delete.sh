#!/bin/bash
#
# Copyright 2011-2020 OpenCDS.org
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

CP=.
for j in `/bin/ls lib/*.jar` ; do
    CP=$CP:$j
done;

java -cp $CP -Dlog4j.configuration=resources/log4j.properties org.opencds.config.cli.RestCli --delete "$@"
