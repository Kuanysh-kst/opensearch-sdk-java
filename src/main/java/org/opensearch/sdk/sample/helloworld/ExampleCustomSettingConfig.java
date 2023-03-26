/*
 * Copyright OpenSearch Contributors
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.sdk.sample.helloworld;

import org.opensearch.common.settings.Setting;
import org.opensearch.common.settings.Setting.RegexValidator;
import org.opensearch.common.settings.Setting.Property;

/**
 * {@link ExampleCustomSettingConfig} contains the custom settings value and their static declarations.
 */
public class ExampleCustomSettingConfig {
    private static final String FORBIDDEN_REGEX = "^((?!forbidden).)*$";
    private static final String URL_ADDRESS_REGEX =
        "/(https?:\\/\\/)?(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)/ ";
    /**
     * A string setting. If the string setting matches the FORBIDDEN_REGEX string and parameter isMatching is true the validation will fail.
     */
    public static final Setting<String> VALIDATED_SETTING = Setting.simpleString(
        "custom.validate",
        new RegexValidator(FORBIDDEN_REGEX, true),
        Property.NodeScope,
        Property.Dynamic
    );

    /**
     * A string setting. If the string setting doesn't match the FORBIDDEN_REGEX string and parameter isMatching is false the validation will fail.
     */
    public static final Setting<String> VALIDATED_SETTING_FALSE = Setting.simpleString(
        "custom.validate",
        new RegexValidator(FORBIDDEN_REGEX, false),
        Property.NodeScope,
        Property.Dynamic
    );

    /**
     * A string setting. If the string setting matches the VALIDATED_URL_SETTING string and parameter isMatching is true the validation will fail.
     */
    public static final Setting<String> VALIDATED_URL_SETTING = Setting.simpleString(
        "custom.validate",
        new RegexValidator(URL_ADDRESS_REGEX, true),
        Property.NodeScope,
        Property.Dynamic
    );
}
